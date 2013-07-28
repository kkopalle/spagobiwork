package com.infinitus.spagobi.custom.dataset;
/* SpagoBI, the Open Source Business Intelligence suite

 * Copyright (C) 2012 Engineering Ingegneria Informatica S.p.A. - SpagoBI Competency Center
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0, without the "Incompatible With Secondary Licenses" notice. 
 * If a copy of the MPL was not distributed with this file, You can obtain one at http://mozilla.org/MPL/2.0/. */


import it.eng.spagobi.tools.dataset.common.datastore.IDataStore;
import it.eng.spagobi.tools.dataset.common.datastore.IField;
import it.eng.spagobi.tools.dataset.common.datastore.IRecord;
import it.eng.spagobi.tools.dataset.common.metadata.IFieldMetaData;
import it.eng.spagobi.tools.dataset.common.metadata.IMetaData;

import java.util.List;

/**
 * @author Andrea Gioia (andrea.gioia@eng.it)
 *
 */
public class MyCustomDatasetTest extends com.infinitus.spagobi.test.AbstractSpagoBITestCase {
	MyCustomDataSet dataset;
        
        public void setUp() throws Exception {
                super.setUp();
                try {
                        dataset = new MyCustomDataSet();
                } catch(Exception t) {
                        System.err.println("An unespected error occurred during setUp: ");
                        t.printStackTrace();
                        throw t;
                }
        }
        
        public void tearDown() throws Exception {
                super.tearDown();
        }
        
         
        public void testLoad() {
                dataset.loadData();
                IDataStore dataStore = dataset.getDataStore();
                assertNotNull(dataStore);
                assertEquals(1, dataStore.getRecordsCount());
                IMetaData metaData = dataStore.getMetaData();
                assertNotNull(metaData);
                assertEquals(3, metaData.getFieldCount());

                IFieldMetaData field1MetaData = metaData.getFieldMeta(0);
                assertNotNull(field1MetaData);
                assertEquals("execType", field1MetaData.getName());
                List<IRecord> rcds = dataStore.findRecords(0, 0);
                assertNotNull(rcds);
                assertEquals(1, rcds.size());
                IRecord record = rcds.get(0);
                IField field = record.getFieldAt(0);
                assertEquals(0, field.getValue());
                
                IFieldMetaData field2MetaData = metaData.getFieldMeta(1);
                assertNotNull(field2MetaData);
                assertEquals("compId", field2MetaData.getName());
                List<IRecord> rcds1 = dataStore.findRecords(1, "INTERNAL");
                assertNotNull(rcds1);
                assertEquals(1, rcds1.size());
                IRecord record1 = rcds1.get(0);
                IField field1 = record1.getFieldAt(1);
                assertEquals("INTERNAL", field1.getValue());
                
                
                IFieldMetaData field3MetaData = metaData.getFieldMeta(2);
                assertNotNull(field3MetaData);
                assertEquals("count", field3MetaData.getName());
                List<IRecord> rcds3 = dataStore.findRecords(2, 500);
                assertNotNull(rcds3);
                assertEquals(1, rcds3.size());
                IRecord record3 = rcds3.get(0);
                IField field3 = record3.getFieldAt(2);
                assertEquals(500, field3.getValue());
        }       
        
 }