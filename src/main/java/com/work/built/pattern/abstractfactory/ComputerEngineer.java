package com.work.built.pattern.abstractfactory;

public class ComputerEngineer {

	private Cpu cpu = null;
	
	private Mainboard mainboard = null;
	
	public void makeComputer(AbstractFactory af){
		/*
		 * 组装机器的基本步骤
		 */
		prepareHardwares(af);
		
		
	}
	
	private void prepareHardwares(AbstractFactory af){
		//这里要去准备CPU和主板的具体实现，为了示例简单，这里只准备这两个
        //可是，装机工程师并不知道如何去创建，怎么办呢？
        
        //直接找相应的工厂获取
		
		this.cpu = af.createCpu();
		this.mainboard = af.createMainboard();
		
		//调试配件是否完好
		this.cpu.calaulate();
		this.mainboard.installCPU();
	}
	
}
