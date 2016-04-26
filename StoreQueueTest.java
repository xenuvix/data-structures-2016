public class StoreQueueTest {
    public static void main(String[] args) {
        StoreQueue sq = new StoreQueue();
        Person p = new Person(1234, 6);
        sq.enqueue(p);
        p = new Person(12345, 5);
        sq.enqueue(p);
        p = new Person(123456, 7);
        sq.enqueue(p);
        p = new Person(123457, 9);
        sq.enqueue(p);
        p = new Person(12, 15);
        sq.enqueue(p);
        p = new Person(123, 17);
        sq.enqueue(p);
        p = new Person(12345678, 8);
        sq.enqueue(p);
        p = new Person(123456789, 10);
        sq.enqueue(p);
        p = new Person(321, 25);
        sq.enqueue(p);
        System.out.println((sq.firstInQueue()).getId());
        sq.dequeue();
        System.out.println((sq.firstInQueue()).getId());
        System.out.println(sq.returnNthPersonInRecord(3).getId());
        System.out.println(sq.returnPersonFromRecord(123).getAge());
        sq.deleteNthPersonFromRecord(3);
        System.out.println(sq.returnNthPersonInRecord(3).getId());
        sq.dequeue();
        System.out.println(sq.returnNthPersonInRecord(3).getId());
        System.out.println((sq.firstInQueue()).getId());
        sq.deleteNthPersonFromRecord(9);
        System.out.println(sq.returnPersonFromRecord(321).getAge);
        System.out.println(sq.returnNthPersonInRecord(9));
        System.out.println(sq.returnNthPersonInRecord(8).getId());


    }
}