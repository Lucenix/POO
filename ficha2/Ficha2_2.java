package com.poo.ficha2;

import java.util.Arrays;

public class Ficha2_2 {
    //2
    int[][] array;

    public int getNumberStudents() {
        return array.length;
    }

    public int getNumberDisc(int student) {
        return array[student].length;
    }

    public int[][] getArray() {
        return array;
    }

    public void setArray(int[][] array) {
        this.array = array;
    }


    public Ficha2_2(int[][] array) {
        this.array = array;
    }

    public int mediaNotasAluno(int aluno) {
        int sum = 0;
        for (int ints : this.array[aluno]) {
            sum += ints;
        }
        return sum/this.array[aluno].length;
    }

    public int somaNotasDisc(int disc) {
        int sum = 0;
        for (int[] ints : this.array) {
            sum += ints[disc];
        }
        return sum;
    }

    public int mediaNotasDisc(int disc) {
        return this.somaNotasDisc(disc)/this.array.length;
    }

    public int maxNotaDisc(int disc) {
        int max = this.array[0][disc];
        for(int i = 1; i<this.array[i].length; i++) {
            if (this.array[i][disc] > max)
                max = this.array[i][disc];
        }
        return max;
    }

    public int minNotaDisc(int disc) {
        int min = this.array[0][disc];
        for(int i = 1; i<this.array[i].length; i++) {
            if (this.array[i][disc] < min)
                min = this.array[i][disc];
        }
        return min;
    }

    public int[] notasMaiores(int valor) {
        int[] notas = new int[this.array.length * this.array[0].length];
        int i = 0;
        for (int[] al: this.array) {
            for (int nota: al) {
                if (nota > valor)
                    notas[i++] = nota;
            }
        }
        int[] r = new int[i];
        System.arraycopy(notas, 0, r, 0, i);
        return r;
    }

    public String notasToString() {
        StringBuilder string = new StringBuilder();
        for (int[] al:
             this.array) {
            string.append(Arrays.toString(al));
        }
        return string.toString();
    }

    public int discMaiorMedia() {
        int i, indmax = 0, mediamax = this.mediaNotasDisc(0), curr;
        for(i = 1; i<this.array[0].length; i++) {
            curr = this.mediaNotasDisc(i);
            if (curr > mediamax) {
                mediamax = curr;
                indmax = i;
            }
        }
        return indmax;
    }
}
