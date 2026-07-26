# Code Review Audit 
Goal: Auditing complete project, refactoring codebase according to critiques 

## 1) First Attempt 
-**Context**: Auditing the complete project of @TaskManager.java along the axes of Readability, Performance, Exception 
Safety, and Encapsulation 
-**Prompt**: Act as a Principal Java Architect. Audit the following Java class. Provide a code review covering:
1. Readability: Are comments clear? Are variables named consistently?  
2. Performance: Are there redundant memory allocations or nested O(N^2) loops?  
3. Exception Safety: Does it guard against nulls, division-by-zero, or bounds violations?  
4. Encapsulation: Is data properly hidden?  

Provide constructive feedback points and a refactored version of the class resolving any vulnerabilities found.  

Here is the code:
[The @TaskManager.java class is pasted here]
-**Response**: 
# 1. Readability

## Good

- Variable names such as `allTasks`, `uniqueTitles`, and `taskLookup` clearly communicate their purposes.
- Method names (`addTask`, `getTaskById`) are descriptive.
- The control flow is simple and easy to follow.

## Suggestions

### 1. Avoid wildcard imports

Instead of:

```java
import java.util.*;
```

Prefer:

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
```

This makes dependencies explicit and improves readability.

### 2. Use more descriptive collection names

Current:

```java
allTasks
taskLookup
```

Suggested:

```java
tasks
tasksById
```

### 3. Avoid printing inside business logic

Instead of:

```java
System.out.println("Duplicate task blocked!");
```

Let the method simply return `false` (or throw an exception) and allow the caller to decide how to display messages.

### 4. Separate demonstration code

The `main()` method is useful for testing but would normally be placed in a separate runner class (e.g., `TaskManagerApp`) in production code.

---

# 2. Performance

## Current Complexity

| Operation | Complexity |
|-----------|------------|
| Duplicate title check | O(1) average |
| Add task | O(1) average |
| Retrieve by ID | O(1) average |
| Print roster | O(N) |

No nested loops or O(N²) algorithms were found.

## Suggestions

### 1. Three collections increase memory usage

The class stores each task in:

- a `List`
- a `Set`
- a `Map`

Although this increases memory usage, it provides fast insertion-order traversal, duplicate checking, and ID lookup. This is an acceptable time-versus-memory tradeoff.

### 2. Avoid repeated getter calls

Instead of:

```java
uniqueTitles.contains(task.getTitle());
uniqueTitles.add(task.getTitle());
```

Use:

```java
String title = task.getTitle();
```

This improves readability and avoids repeated method calls.

### 3. Mutable Task objects may invalidate indexes

If a task's title or ID changes after insertion, the `Set` and `Map` become inconsistent.

Example:

```java
task.setTitle("New Title");
```

The old title remains in `uniqueTitles`.

Making IDs and titles immutable is recommended.

---

# 3. Exception Safety

## Issues

### 1. Missing null check

```java
task.getTitle();
```

will throw a `NullPointerException` if `task` is null.

Validate input first:

```java
Objects.requireNonNull(task);
```

---

### 2. Null titles

`HashSet` allows one null value.

A task with a null title could be inserted unintentionally.

Reject null or blank titles before insertion.

---

### 3. Null IDs

`HashMap` allows a null key.

Reject null IDs before insertion.

---

### 4. Duplicate task IDs are not checked

Only duplicate titles are prevented.

Example:

```java
Task task1 = new Task("T1", "First");
Task task2 = new Task("T1", "Second");
```

The second task silently overwrites the first entry in the map while both remain in the list.

This results in inconsistent internal state.

---

### 5. Blank values

IDs such as:

```text
""
"   "
```

are accepted.

Validate that IDs and titles are not blank.

---

### 6. Partial updates

The method modifies three collections separately:

```java
allTasks.add(task);
uniqueTitles.add(task.getTitle());
taskLookup.put(task.getTaskId(), task);
```

Perform all validation before modifying any collection.

---

### 7. Division-by-zero / bounds violations

Not applicable.

The class performs no arithmetic division and does not access collections by index.

---

# 4. Encapsulation

## Issue

Fields currently have package-private access:

```java
List<Task> allTasks;
Set<String> uniqueTitles;
Map<String, Task> taskLookup;
```

Any class in the package can modify them directly.

Example:

```java
manager.allTasks.clear();
```

This breaks the consistency of the manager.

## Recommendation

Declare the fields as:

```java
private final List<Task> tasks;
private final Set<String> uniqueTitles;
private final Map<String, Task> tasksById;
```

- `private` prevents outside modification.
- `final` prevents reassignment of the collection reference.

---

# Constructive Feedback

1. Make all collection fields `private final`.
2. Replace wildcard imports with explicit imports.
3. Validate that the task, task ID, and title are not null or blank.
4. Check for duplicate task IDs as well as duplicate titles.
5. Perform all validation before modifying internal collections.
6. Remove `System.out.println()` from `addTask()` and let the caller decide how to report failures.
7. Store `task.getTitle()` and `task.getTaskId()` in local variables instead of calling the getters multiple times.
8. Make `Task` IDs and titles immutable if possible.
9. Return an unmodifiable view if exposing the task list.
10. Move the demonstration `main()` method into a separate runner class.

---

# 2) Audit the AI Feedback 
**1) AI Critique Points:**
Make all collection fields private final.  
Replace the wildcard import with explicit imports.  
Validate that the task, ID, and title are non-null and nonblank.  
Check both title uniqueness and ID uniqueness.  
Complete all validation before changing internal state.  
Do not print duplicate warnings inside addTask().  
Store task.getTitle() and task.getTaskId() in local variables.  
Prefer immutable task IDs and titles, or provide controlled update methods that keep the collections synchronized.  
Return an unmodifiable task list when exposing roster data.  
Move main() to a separate runner class in a larger application.  
**2) Implementation Decisions:**
After pasting the suggested code into another file, it compiled. Next I will check which implementation suggestions 
fit the project requirements the best. 
Make all collection fields private final.  
Replace the wildcard import with explicit imports.  
Validate that the task, ID, and title are non-null and nonblank.  
Check both title uniqueness and ID uniqueness.  
Complete all validation before changing internal state.  
Do not print duplicate warnings inside addTask().  
Store task.getTitle() and task.getTaskId() in local variables.  
**Rejected Claims**
I did not select the suggestions that change the requirements of the project (ex: variable naming) or were 
too specific for the task at hand that deviated from project requirements. Another example: making a separate 
runner class. Although this is a good idea offhand, the project requirements deviated from this suggestion.

**3) Refactored Code Diff:** 
1) I made the collection fields private and immutable for encapsulation and immutability  
2) I replaced the wildcard import with explicit ones for performance  
3) I revised the Task class itself, instead of the TaskManager, to validate non-null and non-blank inputs, for robust
boundary conditions 
4) and 5) I added an additional check for ID uniqueness before modifying state, which leads to completing validation 
before changing internal state
6) Stored task and taskId into local variables to reduce repeatedness

All the actual code changes are compiled into @RevisedTask.java and @RevisedTaskManager.java

# 3) Final Evaluation 
Some of the AI suggestions for safety and performance were helpful and fit within the project requirements, and some
were rejected under the basis of needless complexity or nonrelevance. None of the suggestions were blindly copied, 
but audited and reflected under the Developer Oath and incorporated into the TaskManager/Task classes. 


