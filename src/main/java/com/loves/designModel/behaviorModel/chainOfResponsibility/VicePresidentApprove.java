package com.loves.designModel.behaviorModel.chainOfResponsibility;

/**
 * 副总审批
 */
public class VicePresidentApprove extends Approve {
    VicePresidentApprove(String Name) {
        super(Name + " Vice President");
    }

    @Override
    public void ProcessRequest(PurchaseRequest request) {
        if ((10000 <= request.GetSum()) && (request.GetSum() < 50000)) {
            System.out.println("**This request " + request.GetID()
                    + " will be handled by " + this.Name + " **");
        } else {
            successor.ProcessRequest(request);
        }
    }
}
