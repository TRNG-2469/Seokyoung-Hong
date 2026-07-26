## Prompt Log - AI Audit 

# 1) First Attempt 
- **Context**: Email roster class that takes in emails and inputs to database 
- **Prompt**: Act as a security auditor and static analysis engine. Review this Java class and generate a list of issues.
- Group them into three categories: Critical (security vulnerabilities, resource leaks, immediate crashes), Major 
- (performance bottlenecks, logic errors, API misuses), and Minor (code style, naming conventions, redundancy).
- **Response**: | Severity | Issue Description | Location | Fix Strategy |
  |----------|-------------------|----------|--------------|
  | **CRITICAL** | SQL Injection Vulnerability: Concatenating `email` directly into the SQL string allows malicious users to execute arbitrary database commands. | Line 12 | Use `PreparedStatement` with parameterized placeholders. |
  | **CRITICAL** | Resource Leak: The `Statement` object is opened but never closed, consuming database connection handles. | Line 10 | Use try-with-resources. |
  | **MAJOR** | Duplicate Data: `addEmail` uses a `List` without checking if the email already exists, violating roster uniqueness rules. | Line 15 | Switch the backing structure from `ArrayList` to `HashSet`. |
  | **MINOR** | Unused Import: `import java.util.List;` is redundant if the implementation is switched to `Set`. | Line 4 | Remove unused imports. |

# 2) Evaluation 
The AI suggests two critical fixes, in the SQL Injection Vulnerability and Resource Leak. These are first priority 
to solve and the suggested framework of using PreparedStatements and try-with-resources are methods the developer 
is familiar with and robust. Next, the next two are guard checks and cleaning up imports, which after review are 
reasonable fixes and implemented in EmailRosterClean 

# 3) Refinement and Evaluation 
- **Refined Code**: Listed in @EmailRosterClean.java 
- The new code is production ready, safe for users to input emails into, and robust. 
