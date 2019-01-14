package com.testli.data.constants;

public enum MembershipType {

	BASIC(0), PREMIUM(1), FAMILY(2);

	private int membershipCode;

	private MembershipType(int membershipCode) {
		this.membershipCode = membershipCode;
	}

	public int getMembershipCode() {
		return this.membershipCode;
	}

	public static MembershipType getMembershipByCode(int membershipCode) {
		for (MembershipType membershipType : MembershipType.values()) {
			if (membershipType.getMembershipCode() == membershipCode) {
				return membershipType;
			}
		}
		throw new IllegalArgumentException("illegal membership code : " + membershipCode);
	}

}
