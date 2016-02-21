package org.usfirst.frc.team4627.robot.subsystems;
import org.usfirst.frc.team4627.robot.RobotMap;
import org.usfirst.frc.team4627.robot.commands.ElChupasControl;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ElChupaArms extends Subsystem {

	//Declaring Arm motors
	CANTalon leftMotor = new CANTalon(RobotMap.EL_CHUPAS_LEFT_MOTOR);
	CANTalon rightMotor = new CANTalon(RobotMap.EL_CHUPAS_RIGHT_MOTOR);
	CANTalon liftMotor = new CANTalon(RobotMap.EL_CHUPAS_LIFT_MOTOR);
	Solenoid kicker = new Solenoid(RobotMap.EL_CHUPAS_KICKER);
    
	public int motorPosition = 0;
	
	public void setUpEncoder() {
		
		liftMotor.changeControlMode(CANTalon.TalonControlMode.Position);
		liftMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		liftMotor.setPID(1.9, 0.0, 0.0);
		liftMotor.enableControl();	
		
	}
	
	public void shootBoulder(double speed) {
	
		leftMotor.set(-speed);
		rightMotor.set(speed);
		
	}
 
    public void shootKicker(boolean shooting) {
		
    	kicker.set(shooting);
		
	}
    
    public double getEncoderValue() {

    	return liftMotor.get();
    	
    }
    
    public void setMotor() {
    	
    	liftMotor.set(motorPosition);
    	
    }
    
    public void zeroMotorInPlace() {

    	motorPosition = 0;
    	liftMotor.setPosition(0);
    
    }
    
    public void setMotorAutoStart() {
    	
    	
    	motorPosition = 1800;
    	liftMotor.setPosition(1800);
    	
    }
	
	public void initDefaultCommand() {
	
    	setDefaultCommand(new ElChupasControl());
    	
    }
}

