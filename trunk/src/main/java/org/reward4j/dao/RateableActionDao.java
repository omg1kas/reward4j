package org.reward4j.dao;

import org.reward4j.model.RateableAction;

public interface RateableActionDao {

    RateableAction getAction(final String actionName) throws RateableActionNotExistException;
    
    void saveAction(final RateableAction action);
}
