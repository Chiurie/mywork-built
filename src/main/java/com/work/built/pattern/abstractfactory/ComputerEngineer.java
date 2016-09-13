package com.work.built.pattern.abstractfactory;

public class ComputerEngineer {

	private Cpu cpu = null;
	
	private Mainboard mainboard = null;
	
	public void makeComputer(AbstractFactory af){
		/*
		 * ��װ�����Ļ�������
		 */
		prepareHardwares(af);
		
		
	}
	
	private void prepareHardwares(AbstractFactory af){
		//����Ҫȥ׼��CPU������ľ���ʵ�֣�Ϊ��ʾ���򵥣�����ֻ׼��������
        //���ǣ�װ������ʦ����֪�����ȥ��������ô���أ�
        
        //ֱ������Ӧ�Ĺ�����ȡ
		
		this.cpu = af.createCpu();
		this.mainboard = af.createMainboard();
		
		//��������Ƿ����
		this.cpu.calaulate();
		this.mainboard.installCPU();
	}
	
}
