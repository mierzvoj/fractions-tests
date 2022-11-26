package org.example;

import java.io.Serializable;

import com.google.common.annotations.VisibleForTesting;

public final class Fraction implements Serializable {

    private Fraction(final int nominator, final int denominator) {
        this.denominator = denominator;
        this.nominator = nominator;
    }

    public static final Fraction of(final int nominator, final int denominator) {
        if (denominator == 0) {
            if (nominator == 0)
                return INDETERMINATE;
            throw new IllegalArgumentException("Fraction denominator cannot be equal to 0");
        }
        if (denominator == 1) {
            switch (nominator) {
                case 1:
                    return FULL;
                case 2:
                    return HALF;
                case 3:
                    return ONE_THIRD;
            }
        }
        return new Fraction(nominator, denominator);
    }

    public int getNominator() {
        return nominator;
    }

    public int getDenominator() {
        return denominator;
    }

    public double doubleValue() {
        return (double) nominator / (double) denominator;
    }

    @Override
    public boolean equals(final Object rightSide) {
        if (!(rightSide instanceof Fraction)) return false;
        final Fraction that = (Fraction) rightSide;
        return (this == that) || (nominator == that.nominator && denominator == that.denominator);
    }

    @Override
    public int hashCode() {
        return nominator + denominator;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(nominator)
                .append('/')
                .append(denominator)
                .toString();
    }

    public static final Fraction INDETERMINATE = new Fraction(0, 0);
    @VisibleForTesting
    static final Fraction FULL = new Fraction(1, 1);
    @VisibleForTesting
    static final Fraction HALF = new Fraction(1, 2);
    @VisibleForTesting
    static final Fraction ONE_THIRD = new Fraction(1, 3);
    private final int nominator;
    private final int denominator;

//    Operations

    static double multiply(Fraction fr1, Fraction fr2) {
        double nom1 = fr1.getNominator();
        double nom2 = fr2.getNominator();
        double denom1 = fr1.getDenominator();
        double denom2 = fr2.getDenominator();
        double nom = nom1 * nom2;
        double denom = denom1 * denom2;
        double res = nom / denom;
        System.out.println(res);
        return res;
    }

    public static double add(Fraction fr1, Fraction fr2) {
        double nom1 = fr1.getNominator();
        double nom2 = fr2.getNominator();
        double denom1 = fr1.getDenominator();
        double denom2 = fr2.getDenominator();
        double nfdenom = denom1 * denom2;
        double nfnom1 = nom1 * denom2;
        double nfnom2 = nom2 * denom1;
        double res = (nfnom1 + nfnom2) / nfdenom;
        System.out.println(res);
        return res;
    }


    public static void main(String[] args) {
        Fraction fr1 = new Fraction(9, 21);
        Fraction fr2 = new Fraction(3, 5);
        multiply(fr1, fr2);
        add(fr1, fr2);
    }


}
