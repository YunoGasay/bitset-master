/*

*** Вариант 18
*** Реализовать множество над заданным набором объектов. Количество элементов в наборе задается в конструкторе.
***Конкретный элемент набор идентифицируется неотрицательным целым от нуля до количества элементов - 1.
***Операции: пересечение, объединение, дополнение, добавление/удаление заданного элемента (массива элементов),
***проверка принадлежности элемента множеству. Бонус: итератор по множеству.

 */


import java.util.ArrayList;
import java.util.Iterator;

public class BitSetSimple implements Iterable<Integer> {   // реализация множества
    public int[] bitSet;

    public BitSetSimple(int num) {  // Количество элементов в наборе задается в конструкторе
        this.bitSet = new int[num];
    }

    public void add(int num) {  //добавление элемента
        if (num < bitSet.length)
        this.bitSet[num] = 1;
    }

    public void delete(int num) {   //удаление элемента
        if (num < bitSet.length)
        this.bitSet[num] = 0;
    }

    public void add(int[] nums) {   //добавление массива элементов
        for (int num : nums) {
            if (num < bitSet.length)
                this.bitSet[num] = 1;
        }
    }

    public void delete(int[] nums) {    //удаление массива элементов
        for (int num : nums) {
            if (num < bitSet.length)
                this.bitSet[num] = 0;
        }

    }

    public BitSetSimple crossing(BitSetSimple anotherBitSet) { //пересечение
        int[] resBitSet = new int[bitSet.length];
        for (int i = 0 ; i < bitSet.length; i++) {
            if (bitSet[i] == 1 && anotherBitSet.bitSet[i] == 1)
                resBitSet[i] = 1;
        }
        BitSetSimple resultBitSetSimple = new BitSetSimple(bitSet.length);

        for (int i = 0 ; i < resBitSet.length; i++) {
            if (resBitSet[i] == 1) {
                resultBitSetSimple.add(i);
            }
        }

        return resultBitSetSimple;

    }

    public BitSetSimple union(BitSetSimple anotherBitSet) {   //объединение
        int size = bitSet.length > anotherBitSet.bitSet.length ? bitSet.length : anotherBitSet.bitSet.length;
        int[] resBitSet = new int[size];
        for (int i = 0 ; i < bitSet.length; i++) {
            if (bitSet[i] == 1 || anotherBitSet.bitSet[i] == 1)
                resBitSet[i] = 1;
        }
        BitSetSimple resultBitSetSimple = new BitSetSimple(bitSet.length);
        for (int i = 0 ; i < resBitSet.length; i++) {
            if (resBitSet[i] == 1) {
                resultBitSetSimple.add(i);
            }
        }
        return resultBitSetSimple;
    }

    public BitSetSimple complement(BitSetSimple anotherBitSet) {   //дополнение
        int size = bitSet.length > anotherBitSet.bitSet.length ? bitSet.length : anotherBitSet.bitSet.length;
        int[] resBitSet = new int[size];
        for (int i = 0 ; i < bitSet.length; i++) {
            if (bitSet[i] == 0 && anotherBitSet.bitSet[i] == 1)
                resBitSet[i] = 1;
        }
        BitSetSimple resultBitSetSimple = new BitSetSimple(bitSet.length);
        for (int i = 0 ; i < resBitSet.length; i++) {
            if (resBitSet[i] == 1) {
                resultBitSetSimple.add(i);
            }
        }
        return resultBitSetSimple;
    }

    public boolean isExist(int num) {   //проверка принадлежности элемента множеству
        if (num > bitSet.length) return false;
        return bitSet[num] == 1;
    }

    public String getNumbers() {

        String numbers = "";

        for (int i = 0; i < bitSet.length; i++) {
            if (bitSet[i] == 1)
                numbers += i + " ";
        }



        return numbers.trim();
    }


    @Override
    public Iterator iterator() {    //Бонус : итератор по множеству
        Iterator<Integer> it = new Iterator<Integer>() {

            private int currentIndex = 0;
            private int tempIndex;

            @Override
            public boolean hasNext() {
                tempIndex = currentIndex;
                while (tempIndex < bitSet.length) {
                   if ( bitSet[tempIndex] == 0 ) {
                       tempIndex++;
                   } else  {
                       return tempIndex < bitSet.length;
                   }
                }

                return false;
            }

            @Override
            public Integer next() {
                while (bitSet[currentIndex] != 1)
                    currentIndex++;

                return currentIndex++;
            }
        };

        return it;
    }
}
