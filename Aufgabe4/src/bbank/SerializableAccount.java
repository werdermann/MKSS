package bbank;

import java.io.*;

public class SerializableAccount implements Serializable {
    public String number;
    public double amount;

    public SerializableAccount(String number, double amount) {
        this.number = number;
        this.amount = amount;
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(number);
        out.writeDouble(amount);
    }

    @Override
    public String toString() {
        return "SerializableAccount{" +
                "number='" + number + '\'' +
                ", amount=" + amount +
                '}';
    }
}
