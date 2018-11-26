package com.loves.designModel.behaviorModel.chainOfResponsibility;

public class MainTest {
	public static void main(String[] args) {
		
		Client mClient=new Client();
		Approve GroupLeader=new GroupApprove("Tom");
		Approve DepartmentLeader=new DepartmentApprove("Jerry");
		Approve VicePresident=new VicePresidentApprove("Kate");
		Approve President=new PresidentApprove("Bush");
		
		GroupLeader.SetSuccessor(VicePresident);
		DepartmentLeader.SetSuccessor(President);
		VicePresident.SetSuccessor(DepartmentLeader);
		President.SetSuccessor(GroupLeader);
		
		VicePresident.ProcessRequest(mClient.sendRequst(1, 100, 40));
		VicePresident.ProcessRequest(mClient.sendRequst(2, 200, 40));
		VicePresident.ProcessRequest(mClient.sendRequst(3, 300, 40));
		VicePresident.ProcessRequest(mClient.sendRequst(4, 400, 140));
	}
}
