package com.cohort.beta;
import com.cohort.alpha.AccessHolder;

public class PackageOutsider {

    public static void main(String[] args) {
        AccessHolder holder = new AccessHolder();

        holder.publicMethod();

        //holder.protectedMethod();

        /*This fails because you either access protected methods
        from the same package, or different package if SUBCLASSED, which we did not
         */

        //holder.defaultMethod();
        /*This fails because we cannot access default methods
        unless we are in the same package, subclassed or not.
         */

        //holder.privateMethod();
        /*This fails because private methods can only be accessed
        within the same class, much less another package.
         */

    }

}
