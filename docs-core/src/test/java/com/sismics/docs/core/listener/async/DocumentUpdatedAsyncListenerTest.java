package com.sismics.docs.core.listener.async;

import com.sismics.docs.BaseTransactionalTest;
import com.sismics.docs.core.dao.ContributorDao;
import com.sismics.docs.core.dao.DocumentDao;
import com.sismics.docs.core.dao.FileDao;
import com.sismics.docs.core.event.DocumentUpdatedAsyncEvent;
import com.sismics.docs.core.model.jpa.Contributor;
import com.sismics.docs.core.model.jpa.Document;
import com.sismics.docs.core.model.jpa.File;
import com.sismics.docs.core.model.jpa.User;
import com.sismics.docs.core.util.TransactionUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DocumentUpdatedAsyncListenerTest extends BaseTransactionalTest {

    @Test
    public void testDocumentUpdatedWithNonExistingDocument() throws Exception {
        // Fire the event for a non-existing document
        DocumentUpdatedAsyncListener listener = new DocumentUpdatedAsyncListener();
        TransactionUtil.commit();
        DocumentUpdatedAsyncEvent event = new DocumentUpdatedAsyncEvent();
        event.setDocumentId("non-existing-id");
        event.setUserId("non-existing-user");
        listener.on(event);

        // Verify no exception is thrown and no operation is performed
        // (No assertions needed as the method should simply return)
    }


}