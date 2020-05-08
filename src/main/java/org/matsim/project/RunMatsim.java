/* *********************************************************************** *
 * project: org.matsim.*												   *
 *                                                                         *
 * *********************************************************************** *
 *                                                                         *
 * copyright       : (C) 2008 by the members listed in the COPYING,        *
 *                   LICENSE and WARRANTY file.                            *
 * email           : info at matsim dot org                                *
 *                                                                         *
 * *********************************************************************** *
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                   *
 *   See also COPYING, LICENSE and WARRANTY file                           *
 *                                                                         *
 * *********************************************************************** */
package org.matsim.project;

import org.matsim.api.core.v01.Scenario;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.controler.Controler;
import org.matsim.core.controler.OutputDirectoryHierarchy;
import org.matsim.core.scenario.ScenarioUtils;

/**
 * @author nagel
 *
 */
public class RunMatsim{

	public static void main(String[] args) {

		// construct and modify config object:
		// config.xxx().setYyy();

		// Checks if no args
		Config config;
		if( args==null || args.length==0 || args[0]==null ){
			config = ConfigUtils.loadConfig( "scenarios/equil/config.xml" ) ;
		} else {
			 config = ConfigUtils.loadConfig( args ) ;
		}
		// Deletes existing output directory
		config.controler().setOverwriteFileSetting(
				OutputDirectoryHierarchy.OverwriteFileSetting.deleteDirectoryIfExists );


		// load and adapt scenario object:
		// scenario.getXxx().doYyy();

		Scenario scenario = ScenarioUtils.loadScenario( config ) ;


		// load and adapt controler object:
		// controler.doZzz();

		Controler controler = new Controler( scenario ) ;

		// Opens otfvis, an interactive visualizer
		// controler.addOverridingModule( new OTFVisLiveModule() ) ;


		controler.run();
	}
	
}
