package com.cohort.alpha;

//Step 2: Testing access within the same package
public class PackageNeighbor {

    public static void main(String[] args) {
        AccessHolder holder = new AccessHolder();

        holder.publicMethod();
        holder.protectedMethod();
        holder.defaultMethod();

         /*This failed because you cannot access private methods
        /from a different class, even within the same package */
        //holder.privateMethod();

    }

}
