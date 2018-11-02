package com.github.collinalpert.apis.datastructures;

public class Tuple {

    private Tuple() {}

    public static class One<A> {
        private A item1;

        public One(A item1) {
            this.item1 = item1;
        }

        public static <A> One<A> create(A item1) {
            return new One<>(item1);
        }

        public A getItem1() {
            return item1;
        }

        public void setItem1(A item1) {
            this.item1 = item1;
        }
    }

    public static class Two<A, B> {
        private A item1;
        private B item2;

        public Two(A item1, B item2) {
            this.item1 = item1;
            this.item2 = item2;
        }

        public static <A, B> Two<A, B> create(A item1, B item2) {
            return new Two<>(item1, item2);
        }

        public A getItem1() {
            return item1;
        }

        public void setItem1(A item1) {
            this.item1 = item1;
        }

        public B getItem2() {
            return item2;
        }

        public void setItem2(B item2) {
            this.item2 = item2;
        }
    }

    public static class Three<A, B, C> {
        private A item1;
        private B item2;
        private C item3;

        public Three(A item1, B item2, C item3) {
            this.item1 = item1;
            this.item2 = item2;
            this.item3 = item3;
        }

        public static <A, B, C> Three<A, B, C> create(A item1, B item2, C item3) {
            return new Three<>(item1, item2, item3);
        }

        public A getItem1() {
            return item1;
        }

        public void setItem1(A item1) {
            this.item1 = item1;
        }

        public B getItem2() {
            return item2;
        }

        public void setItem2(B item2) {
            this.item2 = item2;
        }

        public C getItem3() {
            return item3;
        }

        public void setItem3(C item3) {
            this.item3 = item3;
        }
    }

    public static class Four<A, B, C, D> {
        private A item1;
        private B item2;
        private C item3;
        private D item4;

        public Four(A item1, B item2, C item3, D item4) {
            this.item1 = item1;
            this.item2 = item2;
            this.item3 = item3;
            this.item4 = item4;
        }

        public static <A, B, C, D> Four<A, B, C, D> create(A item1, B item2, C item3, D item4) {
            return new Four<>(item1, item2, item3, item4);
        }

        public A getItem1() {
            return item1;
        }

        public void setItem1(A item1) {
            this.item1 = item1;
        }

        public B getItem2() {
            return item2;
        }

        public void setItem2(B item2) {
            this.item2 = item2;
        }

        public C getItem3() {
            return item3;
        }

        public void setItem3(C item3) {
            this.item3 = item3;
        }

        public D getItem4() {
            return item4;
        }

        public void setItem4(D item4) {
            this.item4 = item4;
        }
    }

    public static class Five<A, B, C, D, E> {
        private A item1;
        private B item2;
        private C item3;
        private D item4;
        private E item5;

        public Five(A item1, B item2, C item3, D item4, E item5) {
            this.item1 = item1;
            this.item2 = item2;
            this.item3 = item3;
            this.item4 = item4;
            this.item5 = item5;
        }

        public static <A, B, C, D, E> Five<A, B, C, D, E> create(A item1, B item2, C item3, D item4, E item5) {
            return new Five<>(item1, item2, item3, item4, item5);
        }

        public A getItem1() {
            return item1;
        }

        public void setItem1(A item1) {
            this.item1 = item1;
        }

        public B getItem2() {
            return item2;
        }

        public void setItem2(B item2) {
            this.item2 = item2;
        }

        public C getItem3() {
            return item3;
        }

        public void setItem3(C item3) {
            this.item3 = item3;
        }

        public D getItem4() {
            return item4;
        }

        public void setItem4(D item4) {
            this.item4 = item4;
        }

        public E getItem5() {
            return item5;
        }

        public void setItem5(E item5) {
            this.item5 = item5;
        }
    }

    public static class Six<A, B, C, D, E, F> {
        private A item1;
        private B item2;
        private C item3;
        private D item4;
        private E item5;
        private F item6;

        public Six(A item1, B item2, C item3, D item4, E item5, F item6) {
            this.item1 = item1;
            this.item2 = item2;
            this.item3 = item3;
            this.item4 = item4;
            this.item5 = item5;
            this.item6 = item6;
        }

        public static <A, B, C, D, E, F> Six<A, B, C, D, E, F> create(A item1, B item2, C item3, D item4, E item5,
                                                                      F item6) {
            return new Six<>(item1, item2, item3, item4, item5, item6);
        }

        public A getItem1() {
            return item1;
        }

        public void setItem1(A item1) {
            this.item1 = item1;
        }

        public B getItem2() {
            return item2;
        }

        public void setItem2(B item2) {
            this.item2 = item2;
        }

        public C getItem3() {
            return item3;
        }

        public void setItem3(C item3) {
            this.item3 = item3;
        }

        public D getItem4() {
            return item4;
        }

        public void setItem4(D item4) {
            this.item4 = item4;
        }

        public E getItem5() {
            return item5;
        }

        public void setItem5(E item5) {
            this.item5 = item5;
        }

        public F getItem6() {
            return item6;
        }

        public void setItem6(F item6) {
            this.item6 = item6;
        }
    }

    public static class Seven<A, B, C, D, E, F, G> {
        private A item1;
        private B item2;
        private C item3;
        private D item4;
        private E item5;
        private F item6;
        private G item7;

        public Seven(A item1, B item2, C item3, D item4, E item5, F item6, G item7) {
            this.item1 = item1;
            this.item2 = item2;
            this.item3 = item3;
            this.item4 = item4;
            this.item5 = item5;
            this.item6 = item6;
            this.item7 = item7;
        }

        public static <A, B, C, D, E, F, G> Seven<A, B, C, D, E, F, G> create(A item1, B item2, C item3, D item4,
                                                                              E item5, F item6, G item7) {
            return new Seven<>(item1, item2, item3, item4, item5, item6, item7);
        }

        public A getItem1() {
            return item1;
        }

        public void setItem1(A item1) {
            this.item1 = item1;
        }

        public B getItem2() {
            return item2;
        }

        public void setItem2(B item2) {
            this.item2 = item2;
        }

        public C getItem3() {
            return item3;
        }

        public void setItem3(C item3) {
            this.item3 = item3;
        }

        public D getItem4() {
            return item4;
        }

        public void setItem4(D item4) {
            this.item4 = item4;
        }

        public E getItem5() {
            return item5;
        }

        public void setItem5(E item5) {
            this.item5 = item5;
        }

        public F getItem6() {
            return item6;
        }

        public void setItem6(F item6) {
            this.item6 = item6;
        }

        public G getItem7() {
            return item7;
        }

        public void setItem7(G item7) {
            this.item7 = item7;
        }
    }

    public static class Eight<A, B, C, D, E, F, G, H> {
        private A item1;
        private B item2;
        private C item3;
        private D item4;
        private E item5;
        private F item6;
        private G item7;
        private H item8;

        public Eight(A item1, B item2, C item3, D item4, E item5, F item6, G item7, H item8) {
            this.item1 = item1;
            this.item2 = item2;
            this.item3 = item3;
            this.item4 = item4;
            this.item5 = item5;
            this.item6 = item6;
            this.item7 = item7;
            this.item8 = item8;
        }

        public static <A, B, C, D, E, F, G, H> Eight<A, B, C, D, E, F, G, H> create(A item1, B item2, C item3, D item4,
                                                                                    E item5, F item6, G item7, H item8) {
            return new Eight<>(item1, item2, item3, item4, item5, item6, item7, item8);
        }

        public A getItem1() {
            return item1;
        }

        public void setItem1(A item1) {
            this.item1 = item1;
        }

        public B getItem2() {
            return item2;
        }

        public void setItem2(B item2) {
            this.item2 = item2;
        }

        public C getItem3() {
            return item3;
        }

        public void setItem3(C item3) {
            this.item3 = item3;
        }

        public D getItem4() {
            return item4;
        }

        public void setItem4(D item4) {
            this.item4 = item4;
        }

        public E getItem5() {
            return item5;
        }

        public void setItem5(E item5) {
            this.item5 = item5;
        }

        public F getItem6() {
            return item6;
        }

        public void setItem6(F item6) {
            this.item6 = item6;
        }

        public G getItem7() {
            return item7;
        }

        public void setItem7(G item7) {
            this.item7 = item7;
        }

        public H getItem8() {
            return item8;
        }

        public void setItem8(H item8) {
            this.item8 = item8;
        }
    }

    public static class Nine<A, B, C, D, E, F, G, H, I> {
        private A item1;
        private B item2;
        private C item3;
        private D item4;
        private E item5;
        private F item6;
        private G item7;
        private H item8;
        private I item9;

        public Nine(A item1, B item2, C item3, D item4, E item5, F item6, G item7, H item8, I item9) {
            this.item1 = item1;
            this.item2 = item2;
            this.item3 = item3;
            this.item4 = item4;
            this.item5 = item5;
            this.item6 = item6;
            this.item7 = item7;
            this.item8 = item8;
            this.item9 = item9;
        }

        public static <A, B, C, D, E, F, G, H, I> Nine<A, B, C, D, E, F, G, H, I> create(A item1, B item2, C item3,
                                                                                         D item4, E item5, F item6,
                                                                                         G item7, H item8, I item9) {
            return new Nine<>(item1, item2, item3, item4, item5, item6, item7, item8, item9);
        }

        public A getItem1() {
            return item1;
        }

        public void setItem1(A item1) {
            this.item1 = item1;
        }

        public B getItem2() {
            return item2;
        }

        public void setItem2(B item2) {
            this.item2 = item2;
        }

        public C getItem3() {
            return item3;
        }

        public void setItem3(C item3) {
            this.item3 = item3;
        }

        public D getItem4() {
            return item4;
        }

        public void setItem4(D item4) {
            this.item4 = item4;
        }

        public E getItem5() {
            return item5;
        }

        public void setItem5(E item5) {
            this.item5 = item5;
        }

        public F getItem6() {
            return item6;
        }

        public void setItem6(F item6) {
            this.item6 = item6;
        }

        public G getItem7() {
            return item7;
        }

        public void setItem7(G item7) {
            this.item7 = item7;
        }

        public H getItem8() {
            return item8;
        }

        public void setItem8(H item8) {
            this.item8 = item8;
        }

        public I getItem9() {
            return item9;
        }

        public void setItem9(I item9) {
            this.item9 = item9;
        }
    }

    public static class Ten<A, B, C, D, E, F, G, H, I, J> {
        private A item1;
        private B item2;
        private C item3;
        private D item4;
        private E item5;
        private F item6;
        private G item7;
        private H item8;
        private I item9;
        private J item10;

        public Ten(A item1, B item2, C item3, D item4, E item5, F item6, G item7, H item8, I item9, J item10) {
            this.item1 = item1;
            this.item2 = item2;
            this.item3 = item3;
            this.item4 = item4;
            this.item5 = item5;
            this.item6 = item6;
            this.item7 = item7;
            this.item8 = item8;
            this.item9 = item9;
            this.item10 = item10;
        }

        public static <A, B, C, D, E, F, G, H, I, J> Ten<A, B, C, D, E, F, G, H, I, J> create(A item1, B item2, C item3,
                                                                                              D item4, E item5, F item6,
                                                                                              G item7, H item8, I item9,
                                                                                              J item10) {
            return new Ten<>(item1, item2, item3, item4, item5, item6, item7, item8, item9, item10);
        }

        public A getItem1() {
            return item1;
        }

        public void setItem1(A item1) {
            this.item1 = item1;
        }

        public B getItem2() {
            return item2;
        }

        public void setItem2(B item2) {
            this.item2 = item2;
        }

        public C getItem3() {
            return item3;
        }

        public void setItem3(C item3) {
            this.item3 = item3;
        }

        public D getItem4() {
            return item4;
        }

        public void setItem4(D item4) {
            this.item4 = item4;
        }

        public E getItem5() {
            return item5;
        }

        public void setItem5(E item5) {
            this.item5 = item5;
        }

        public F getItem6() {
            return item6;
        }

        public void setItem6(F item6) {
            this.item6 = item6;
        }

        public G getItem7() {
            return item7;
        }

        public void setItem7(G item7) {
            this.item7 = item7;
        }

        public H getItem8() {
            return item8;
        }

        public void setItem8(H item8) {
            this.item8 = item8;
        }

        public I getItem9() {
            return item9;
        }

        public void setItem9(I item9) {
            this.item9 = item9;
        }

        public J getItem10() {
            return item10;
        }

        public void setItem10(J item10) {
            this.item10 = item10;
        }
    }
}
