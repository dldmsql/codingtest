package com.company.swea_01;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.NoSuchElementException;

class UserSolution2
{
    private PriorityQueue<Order> maedo, maesu, contract;
    private int mNummber, time;
    class Order implements Comparable<Order>
    {
        int mNumber, mStock, mQuantity, mPrice, time;
        public Order(int mNumber, int mStock, int mQuantity, int mPrice, int time){
            this.mNumber = mNumber; this.mStock = mStock; this.mQuantity = mQuantity; this.mPrice = mPrice; this.time = time;
        }

        @Override
        public int compareTo(Order o) { // 매도
            if(this.mPrice == o.mPrice){
                return this.mNumber - o.mNumber; // 번호가 낮은 순
            }
            return this.mPrice - o.mPrice; // 가격 낮은 순
        }
    }
    public interface Queue<E> {
        boolean offer(E e);
        E poll();
        E peek();
    }
    public class PriorityQueue<E> implements Queue<E>{
        private final Comparator<? super E> comparator; // 우선순위를 결정
        private static final int DEFAULT_CAPACITY = 10;

        private int size; // 배열에 담긴 원소의 개수
        private Object[] array; //  원소를 담을 배열

        public PriorityQueue(){
            this(null);
        }
        public PriorityQueue(Comparator<? super E> comparator) {
            this.array = new Object[DEFAULT_CAPACITY];
            this.size = 0;
            this.comparator = comparator;
        }
        public PriorityQueue(int capacity){
            this(capacity, null);
        }
        public PriorityQueue(int capacity, Comparator<? super E> comparator){
            this.array = new Object[capacity];
            this.size = 0;
            this.comparator = comparator;
        }
        private int getParent(int index){
            return index/2;
        }
        private int getLeftChild(int index){
            return index*2;
        }
        private int getRightChild(int index){
            return index*2 +1;
        }
        @Override
        public boolean offer(E e) {
            if(size +1 == array.length){ // 배열이 꽉 차있으면 늘린다
                resize(array.length*2);
            }
            sift(size + 1, e);
            size++;
            return true;
        }

        private void sift(int index, E target) {
            if(comparator != null){
                siftComparator(index, target, comparator);
            } else {
                siftComparator(index, target);
            }
        }
        private void siftComparator(int index, E target, Comparator<? super E> comparator){
            while(index > 1){ // root보다 클 때까지만 탐색
                int parent = getParent(index); // 삽입노드의 부모 노드 인덱스
                Object parentVal = array[parent]; // 부모 노드의 값
                // 타겟 노드 우선순위가 부모 보다 크면 종료
                if(comparator.compare(target, (E) parentVal) >= 0) {break;}
                array[index] = parentVal; // 현재 삽입 위치에 부모 노드 값으로 바꾸기
                index = parent; // 타겟 노드의 위치를 부모 노드의 위치로 바꾸기
            }
            array[index] = target; // 최종 삽입 될 위치에 타켓 노드 요소 저장
        }
        private  void siftComparator(int index, E target){
            Comparable<? super E> comparator = (Comparable<? super E>) target;

            while(index > 1){
                int parent = getParent(index);
                Object parentVal = array[parent];

                if(comparator.compareTo((E)parentVal) >= 0) {break;}
                array[index] = parentVal;
                index = parent;
            }
            array[index] = comparator;
        }
        @Override
        public E poll() {
            if(array[1] == null){
                return null;
            }
            return remove();
        }

        public E remove() {
            if(array[1] == null){
                throw new NoSuchElementException();
            }
            E result = (E) array[1]; // 삭제된 원소 반환하기 위함
            E target = (E) array[size]; // 타깃 원소

            array[size] = null; // 타깃 노드 비우기
            size--; // 사이즈 감소
            siftDown(1, target);

            return result;
        }
        private void siftDown(int index, E target){
            if(comparator != null){
                siftDownComparator(index , target, comparator);
            } else {
                siftDownComparator(index, target);
            }
        }
        private void siftDownComparator(int index, E target) {
            Comparable<? super E> comp = (Comparable<? super E>) target;

            array[index] = null;

            int parent = index;
            int child;

            while((child = (parent << 1)) <= size) {

                int right = child + 1;

                Object c = array[child];

                if(right <= size && ((Comparable<? super E>)c).compareTo((E)array[right]) > 0) {
                    child = right;
                    c = array[child];
                }

                if(comp.compareTo((E) c) <= 0){
                    break;
                }
                array[parent] = c;
                parent = child;

            }
            array[parent] = comp;

            if(array.length > DEFAULT_CAPACITY && size < array.length / 4) {
                resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
            }

        }

        private void siftDownComparator(int index, E target, Comparator<? super E> comparator) {
            array[index] = null;

            int parent = index;
            int child ;

            while ((child = getLeftChild(parent))<= size){
                int right = getRightChild(parent);
                Object childVal = array[child];

                if(right <= size && comparator.compare((E)childVal, (E)array[right])>0) {
                    child = right;
                    childVal = array[child];
                }
                if(comparator.compare(target, (E) childVal ) <=0){break;}
                array[parent] = childVal;
                parent = child;
            }
            array[parent] = target;
            if(array.length > DEFAULT_CAPACITY && size < array.length / 4) {
                resize(Math.max(DEFAULT_CAPACITY, array.length /2));
            }
        }

        @Override
        public E peek() {
            if(array[1] == null ) throw new NoSuchElementException();
            return (E)array[1];
        }
        private void resize(int newCapacity){
            Object[] newArray = new Object[newCapacity];

            for(int i =1; i<= size; i++){
                newArray[i] = array[i];
            }
            this.array = null;
            this.array = newArray;
        }
        public int size(){
            return this.size;
        }
        public boolean isEmpty(){
            return size==0;
        }
        public boolean contains(Object value){
            for(int i = 1; i <= size; i++){
                if(array[i].equals(value)){
                    return true;
                }
            }
            return false;
        }
        public Object get(Object value){
            for(int i = 1; i <= size; i++){
                if(array[i].equals(value)){
                    return array[i];
                }
            }
            return null;
        }
        public E remove(Object value){
            E result;
            E target = (E) array[size]; // 타깃 원소
            for(int i = 1; i <= size; i++){
                if(array[i].equals(value)){
                    result = (E) array[i];
                    size--;
                    siftDown(i, target);
                    return result;
                }
            }
            return null;
        }
        public void clear(){
            for(int i =0; i< array.length; i++){
                array[i] = null;
            }
            size = 0;
        }
        public Object[] toArray(){
            return toArray(new Object[size]);
        }

        public <T> T[] toArray(T[] ar) {
            if(ar.length <= size){
                return (T[]) Arrays.copyOfRange(array, 1, size + 1, ar.getClass());
            }
            System.arraycopy(array, 1, ar, 0, size);
            return ar;
        }
    }
    private Comparator<Order> comp = new Comparator<Order>() { // 매수
        @Override
        public int compare(Order o1, Order o2) {
            if(o1.mPrice == o2.mPrice){
                return o1.mNumber - o2.mNumber; // 번호가 낮은 순
            }
            return o2.mPrice - o1.mPrice; // 가격이 높은 순
        }
    };
    private Comparator<Order> compTime = new Comparator<Order>() { // 체결
        @Override
        public int compare(Order o1, Order o2) {
            return o1.time - o2.time; // 시간 순으로(숫자가 낮은 순)
        }
    };

    public void init()
    {
        this.maedo = new PriorityQueue<>();
        this.maesu = new PriorityQueue<>(comp);
        this.contract = new PriorityQueue<>(compTime); // 시간순

        this.mNummber = 1;
        this.time = 1;

    }

    public int buy(int mNumber, int mStock, int mQuantity, int mPrice)
    {
        int remain;
        mNumber = this.mNummber;
        this.mNummber++;
        if(this.maedo.isEmpty()) { // 미체결 매도 주문이 없는 경우
            this.maesu.offer(new Order(mNumber, mStock, mQuantity, mPrice, 0));
        }
        while(!this.maedo.isEmpty()) { // 매도 주문이 있으면
            Order oMaedo = this.maedo.poll(); // 가장 비싼 거
            if(oMaedo.mStock == mStock && oMaedo.mPrice <= mPrice){
                remain = oMaedo.mQuantity - mQuantity;
                if( remain > 0 ) { // 남은 거 다시 저장
                    oMaedo.mQuantity = mQuantity; // 주문 들어온 수량 = 팔린 거
                    oMaedo.time = this.time; // 시간 기록
                    this.contract.offer(oMaedo); // 체결에 저장
                    this.time++; // 시간 ++
                    this.maedo.offer(new Order(mNumber, mStock, remain ,mPrice, 0 )); //남은 거 다시 매도에 저장
                } 
                if( remain == 0) {
                    oMaedo.time = this.time; // 시간 기록
                    this.contract.offer(oMaedo); // 체결에 저장
                    this.time++; // 시간 ++
                    break; // 주문 들어온 거 다 팔렸다
                }
            } else {
                this.maesu.offer(new Order(mNumber, mStock, mQuantity, mPrice, 0));
                break;
            }
        }
        if(this.maesu.contains(mNumber)) return ((Order)this.maesu.get(mNumber)).mQuantity;
        else return 0;
    }

    public int sell(int mNumber, int mStock, int mQuantity, int mPrice)
    {
        int remain;
        mNumber = this.mNummber;
        this.mNummber++;
        if(!this.maesu.isEmpty()){
            Order oMaesu = this.maesu.peek();
            if(oMaesu.mStock == mStock && oMaesu.mPrice >= mPrice ){
                remain = oMaesu.mQuantity - mQuantity;
                this.maesu.remove(); // 미체결 매수 주문에서 제거
                if( remain < 0 ) {
                    this.maedo.offer(new Order(mNumber, mStock, Math.abs(remain),mPrice, 0 ));
                } else {
                    oMaesu.mQuantity = remain;
                    this.maesu.offer(oMaesu);
                }
            }
            oMaesu.time = this.time;
            this.contract.offer(oMaesu);
            this.time++;
            if(!this.maedo.contains(mNumber)) return this.maedo.peek().mQuantity;
            else return 0;
        }
        else { // 미체결 매도 주문이 없는 경우
            this.maedo.offer(new Order(mNumber, mStock, mQuantity, mPrice, 0));
            return this.maedo.peek().mQuantity;
        }
    }

    public void cancel(int mNumber)
    {
        if(this.maesu.contains(mNumber)){
            this.maesu.remove(mNumber);
        }
        if(this.maedo.contains(mNumber)) this.maedo.remove(mNumber);
    }

    public int bestProfit(int mStock) {
       // mstock인 거만 추출해서 배열로 뺄까?
        // 시간순으로 이미 정렬이 되어 있음.
        int[] remain = new int[this.contract.size()];
        System.out.println(this.contract.size() + "DDD");
        if(this.contract.size() > 3 ) {
            for (int i = 1; i < this.contract.size(); i++) {
                Order preOrder = (Order) this.contract.array[i - 1];
                Order order = (Order) this.contract.array[i];
                if (order.mStock == mStock) {
                    remain[i - 1] = Math.abs(preOrder.mPrice - order.mPrice);
                }
            }
            int cnt = 0;
            int max = 0;
            int index = 0;
            for (int val : remain) {
                cnt++;
                if (val > max) {
                    max = val;
                    index = cnt;
                }
            }
            return index;
        }
        else return 0;
    }
}