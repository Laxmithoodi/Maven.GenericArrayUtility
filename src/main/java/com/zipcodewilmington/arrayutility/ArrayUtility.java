package com.zipcodewilmington.arrayutility;




import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * Created by leon on 3/6/18.
 */



public class ArrayUtility <S> {

    S[] inputArray;
    S[] mergeArray;

    public ArrayUtility(S[] inputArray) {
        this.inputArray = inputArray;

    }


    public Integer countDuplicatesInMerge(S[] arrayToMerge, S valueToEvaluate) {

        mergeArray = concatenate(inputArray, arrayToMerge);

        int count =0;
        for(S s : mergeArray){
            if(s == valueToEvaluate)
                count++;
        }

        return count;
    }




    public  S[] concatenate(S[] inputArray, S[] arrayToMerge) {

        S[] mergeArray = Arrays.copyOf(inputArray, inputArray.length + arrayToMerge.length);
        System.arraycopy(arrayToMerge, 0, mergeArray, inputArray.length, arrayToMerge.length);
        return mergeArray;

    }




    public S getMostCommonFromMerge(S[] arrayToMerge) {

       mergeArray = concatenate(inputArray, arrayToMerge);
      //  List<Integer> mostCommon = Arrays.asList(inputArray.length);

     //   mostCommon = Arrays.stream(inputArray).reduce(BinaryOperator.maxBy(inputArray, arrayToMerge) >

        S mostcommonElement=mergeArray[0];
        int mostCommonOcc = 0;
        for(S s : mergeArray){
            if(getNumberOfOccurrences(s) > mostCommonOcc){
                mostcommonElement = s;
                mostCommonOcc = getNumberOfOccurrences(s);
            }
        }
        return mostcommonElement;

    }




    public int getNumberOfOccurrences(S valueToEvaluate) {

       int count =0;
       for(S s : inputArray){
           if( s== valueToEvaluate)
               count++;
       }
       return count;
    }




    public S[] removeValue(S valueToRemove) {

        List<S> list = new ArrayList<>();

        list = Arrays.stream(inputArray).filter(e -> !e.equals(valueToRemove))
                .collect(Collectors.toList());

        S[] newArray = (S[])Array.newInstance(inputArray.getClass().getComponentType(), list.size());

        return list.toArray(newArray);

    }

}
