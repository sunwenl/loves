package com.loves.designModel.behaviorModel.chainOfResponsibility;

/**
 * 组长审批
 */
public class GroupApprove extends Approve {
    GroupApprove(String Name) {
        super(Name + " GroupLeader");
    }

    @Override
    public void ProcessRequest(PurchaseRequest request) {
        if (request.GetSum() < 5000) {
            System.out.println("**This request " + request.GetID()
                    + " will be handled by "
                    + this.Name + " **");
        } else {
            successor.ProcessRequest(request);
        }
    }
}
