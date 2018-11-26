package com.loves.designModel.behaviorModel.chainOfResponsibility;

/**
 * 部长审批
 */
public class DepartmentApprove extends Approve {
    DepartmentApprove(String Name) {
        super(Name + " DepartmentLeader");

    }

    @Override
    public void ProcessRequest(PurchaseRequest request) {
        if ((5000 <= request.GetSum()) && (request.GetSum() < 10000)) {
            System.out.println("**This request " + request.GetID()
                    + " will be handled by " + this.Name + " **");
        } else {
            successor.ProcessRequest(request);
        }
    }
}
