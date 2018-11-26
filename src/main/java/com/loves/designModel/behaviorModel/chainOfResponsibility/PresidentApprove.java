package com.loves.designModel.behaviorModel.chainOfResponsibility;

/**
 * 总裁审批
 */
public class PresidentApprove extends Approve {
    PresidentApprove(String Name) {
        super(Name + " President");

    }

    @Override
    public void ProcessRequest(PurchaseRequest request) {
        // TODO Auto-generated method stub
        if (50000 <= request.GetSum()) {
            System.out.println("**This request " + request.GetID()
                    + " will be handled by " + this.Name + " **");
        } else {
            successor.ProcessRequest(request);
        }
    }
}
