public class BitSetSimple {  
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
        int size = Math.max(bitSet.length, anotherBitSet.bitSet.length);
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
        int size = Math.max(bitSet.length, anotherBitSet.bitSet.length);
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

        StringBuilder numbers = new StringBuilder();

        for (int i = 0; i < bitSet.length; i++) {
            if (bitSet[i] == 1)
                numbers.append(i).append(" ");
        }

        return numbers.toString().trim();
    }
}
