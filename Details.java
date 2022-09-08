package assessment.worker;

import java.rmi.RemoteException;
import java.util.List;

public interface Details {
    public void displayDepartment() throws RemoteException;
    public void usingAlias() throws RemoteException;
    public void usingInstr()throws RemoteException;
}
