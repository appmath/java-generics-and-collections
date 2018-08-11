package generics.cb2subtypingandwildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 2.4. The Get and Put Principle
 *
 * The Get and Put Principle:
 * Extends: use an extends wildcard when you only get values out of a structure (Extend => gEt)
 * Super:   use a super wildcard when you only put values into a structure      (sUper  => pUt)
 * None:    don’t use a wildcard when you both get and put.                     (nOne   => bOth)
 *
 * You may find it helpful to think of ?
 * extends T as containing every type in an interval bounded by the type of null below and by T above
 * (where the type of null is a subtype of every reference type).
 * Similarly, you may think of ? super T as containing every type in an interval bounded by T below and
 * by Object above
 *
 */
public class TheGetandPutPrinciple {
    public static void main(String[] args) {
        try {

            List<Integer> ints = Arrays.asList(1, 2, 3);
            assert sum(ints) == 6.0;

            List<Double> doubles = Arrays.asList(2.78, 3.14);
            assert sum(doubles) == 5.92;


            List<Number> nums = Arrays.<Number>asList(1, 2, 2.78, 3.14);
            assert sum(nums) == 8.92;


            nums = new ArrayList<Number>();
            double sum = sumCount(nums, 5);
            assert sum == 10;


            List<? extends Number> extNums = ints;
            List<? super Integer> supInt = ints;
            sum(extNums);
            count(supInt, 5);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    /**
     * GET: We are getting the values out of a structure: EXTENDS
     * You may find it helpful to think of ? extends T as containing every type in an interval bounded by
     * the type of null below and by T above (where the type of null is a subtype of every reference type).
     */
    public static double sum(Collection<? extends Number> nums){
        double s = 0.0;
        for (Number num : nums) {
            s += num.doubleValue();
        }
         return s;
    }

		/**
		 * Shows how extends is effectively a GET!  Remember: extends == bounded == locked == GET
		 */
		private void extendUsage() {
				List<Integer> ints = new ArrayList<>();
				ints.add(1);
				ints.add(2);
				List<? extends Number> nums = ints; // // CAUTION: BOUNDED AND LOCKED!
				// nums.add(3.14); or even nums.add(3) throw a compile-time error!
		}


    /**
     * PUT: We are putting the values into a structure: SUPER
     * you may think of ? super T as containing every type in an interval bounded by T below and by Object above.
     */
    public static void count(Collection<? super Integer> ints, int n){
        for (int i = 0; i < n; i++) {
           ints.add(i);
        }
    }

		/**
		 * Shows that super is effectively a PUT! Remember: super == unbounded == locked == put (more freedom!)
		 */
		private void superUsage() {
				List<Object> objs = new ArrayList<>();
				objs.add(1);
				objs.add("Two");

				List<? super Integer> ints = objs;   // CAUTION: LOCKED!
				ints.add(3);
				// double dbl = sum(ints); compile-time error
		}

		/**
     * BOTH: We are getting the values out of a structure and putting the values into a structure: NONE
     */
    public static double sumCount(Collection<Number> nums, int n){
        count(nums, n);
        return sum(nums);
    }



}


