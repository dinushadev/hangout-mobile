/*
 * Copyright 2010-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nandika.hang_out.framwork;



import android.app.Application;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author Roy Clarkson
 */
public class MainApplication extends Application {
	private SQLiteOpenHelper repositoryHelper;

	// ***************************************
	// Application Methods
	// ***************************************
	@Override
	public void onCreate() {
		// create a new ConnectionFactoryLocator and populate it with a Twitter ConnectionFactory
	
		// set up the database and encryption
		//this.repositoryHelper = new SQLiteConnectionRepositoryHelper(this);
	//	this.connectionRepository = new SQLiteConnectionRepository(this.repositoryHelper,
	//			this.connectionFactoryRegistry, AndroidEncryptors.text("password", "5c0744940b5c369b"));
	}

	// ***************************************
	// Private methods
	// ***************************************
	

	// ***************************************
	// Public methods
	// ***************************************
	/*public ConnectionRepository getConnectionRepository() {
		return this.connectionRepository;
	}
*/

}
