package com.infinitus.spagobi.custom.dataset;


import org.apache.log4j.Logger;

import it.eng.spagobi.tools.dataset.bo.JavaClassDataSet;
import it.eng.spagobi.tools.dataset.common.datastore.DataStore;
import it.eng.spagobi.tools.dataset.common.datastore.Field;
import it.eng.spagobi.tools.dataset.common.datastore.IDataStore;
import it.eng.spagobi.tools.dataset.common.datastore.IField;
import it.eng.spagobi.tools.dataset.common.datastore.IRecord;
import it.eng.spagobi.tools.dataset.common.datastore.Record;
import it.eng.spagobi.tools.dataset.common.metadata.FieldMetadata;
import it.eng.spagobi.tools.dataset.common.metadata.IMetaData;



public class MyCustomDataSet extends JavaClassDataSet {
	
	IDataStore dataStore;
	@Override
	public IDataStore getDataStore() {
		return dataStore;
	}
	private static transient Logger logger = Logger.getLogger(MyCustomDataSet.class);
	public void loadData(int offset, int fetchSize, int maxResults) {
		logger.debug("IN");
		loadData();
		logger.debug("OUT");

	}
	public void loadData() {
		logger.debug("IN");
		dataStore = new DataStore();
        IMetaData meta = dataStore.getMetaData();

        FieldMetadata execType = new FieldMetadata("execType", Integer.class);
        execType.setAlias("Execution Type");
        meta.addFiedMeta(execType);
        
        FieldMetadata compId = new FieldMetadata("compId", String.class);
        compId.setAlias("CompId");
        meta.addFiedMeta(compId);
        
        FieldMetadata compIdExecCount = new FieldMetadata("count", Integer.class);
        compIdExecCount.setAlias("CompId by Exec Type Count");
        meta.addFiedMeta(compIdExecCount);
        
        IField f = null;
        IRecord rec = null;

        rec = new Record();

        f = new Field(); 
        f.setValue( 0); 
        rec.appendField(f);

        
        f = new Field(); 
        f.setValue( "INTERNAL"); 
        rec.appendField(f);
       
        
        f = new Field(); 
        f.setValue( compIdCount); 
        rec.appendField(f);
        dataStore.appendRecord(rec);
        
       

		logger.debug("OUT");

	}

	Integer compIdCount = new Integer(500);
}
