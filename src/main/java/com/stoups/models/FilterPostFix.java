package com.stoups.models;

/**
 * Created by astouparenko on 4/11/2017.
 */
public enum FilterPostFix {

    eq, //Equal: Exact match equal.
    not_eq, //Not Equal: Exact match equal.
    gt, //Greater than works only on numbers.
    gte, //Greater than or equal to works only on numbers.
    lt, //Less than works only on numbers.
    lte, //Less than or equal to works only on numbers.
    prefix, //Prefix of a value only works on strings.
    exists, //The value is not null.
    not_exists, //The value is null.
    in, //The value exists within the (comma separated) array.
    not_in; //The values must not exists within the (comma separated) array.


}
