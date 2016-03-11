package org.usfirst.frc.team4627.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoPlacement2 extends CommandGroup {
    
    public  AutoPlacement2() {
    	
    	addSequential(new Wait(1));
    	addSequential(new AutoTurn(30));
    	addSequential(new StopDriveMotors());
    	addSequential(new Wait(0.42));
    	addSequential(new DefenseShotAngleSet());
    	addSequential(new Wait(0.7));
    	addSequential(new TheAligner());
    	
    	
    }
}
