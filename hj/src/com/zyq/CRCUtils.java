package com.zyq;

public class CRCUtils {

	// ���ݻ���HJ-t212Э����������У��λ
	public static String getCrc(byte[] data) {
		int high;
		int flag;

		// 16λ�Ĵ�����������λ��Ϊ1
		int wcrc = 0xffff;
		for (int i = 0; i < data.length; i++) {
			// 16 λ�Ĵ����ĸ�λ�ֽ�
			high = wcrc >> 8;
			// ȡ��У�鴮��һ���ֽ��� 16 λ�Ĵ����ĸ�λ�ֽڽ��С��������
			wcrc = high ^ data[i];

			for (int j = 0; j < 8; j++) {
				flag = wcrc & 0x0001;
				// ����� 16 �Ĵ���������һλ
				wcrc = wcrc >> 1;
				// ������(���λ)�Ƴ�����λ�� 1,�����ɶ���ʽ 1010 0000 0000 0001 ������Ĵ������С��������
				if (flag == 1)
					wcrc ^= 0xa001;
			}
		}

		return Integer.toHexString(wcrc);
	}
	
	public static void main(String[] args) {
		
	}

}
