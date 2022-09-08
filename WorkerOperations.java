package assessment.worker;

import java.rmi.RemoteException;

public class WorkerOperations {
    public void alias() throws RemoteException {
        WorkerData wd = new WorkerData();
        wd.usingAlias();
    }
    public void instr() throws RemoteException {
        WorkerData wd = new WorkerData();
        Worker w = new Worker();
        wd.usingInstr();
    }
    public void display() throws RemoteException {
        WorkerData wd = new WorkerData();
        wd.displayDepartment();
    }
    public static void main(String[] args) throws RemoteException {
        WorkerOperations obj = new WorkerOperations();
        obj.alias();
        obj.instr();
        obj.display();
    }
}
