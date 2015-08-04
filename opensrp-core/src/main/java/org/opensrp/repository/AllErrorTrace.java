
package org.opensrp.repository;

import java.util.List;

import org.ektorp.CouchDbConnector;
import org.ektorp.support.GenerateView;
import org.ektorp.support.View;
import org.motechproject.dao.MotechBaseRepository;
import org.opensrp.common.AllConstants;
import org.opensrp.domain.ErrorTrace;
import org.opensrp.domain.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * @author muhammad.ahmed@ihsinformatics.com
 *  Created on May 25, 2015
 */
@Repository
public class AllErrorTrace extends MotechBaseRepository<ErrorTrace> {
	
	
	@Autowired
	protected AllErrorTrace(
			@Qualifier(AllConstants.OPENSRP_ERRORTRACE_DATABASE) CouchDbConnector db) {
		super(ErrorTrace.class, db);
	}

//	@GenerateView
	public ErrorTrace findById(String _id) {
		
		/*db.queryView(createQuery("_id").keys(_id)
				.includeDocs(true), ErrorTrace.class);*/
	ErrorTrace errors=	get(_id);
		//List<ErrorTrace> errors = queryView("_id", _id);
		if (errors == null ) {
			return null;
		}
		return errors;
	}
	public boolean exists(String id) {
		return findById(id) != null;
	}
	
	@View(name = "all_errors", map = "function(doc) {  emit(doc.id);  }")
	public List<ErrorTrace> findAllErrors() {
		return db.queryView(createQuery("all_errors").includeDocs(true),
				ErrorTrace.class);
	}

	@View(name = "all_unsolved_errors", map = "function(doc) { if (doc.status === 'unsolved') { emit(doc.id); } }")
	public List<ErrorTrace> findAllUnSolvedErrors() {
		return db.queryView(createQuery("all_unsolved_errors").includeDocs(true),
				ErrorTrace.class);
	}
	
	@View(name = "all_solved_errors", map = "function(doc) { if (doc.status === 'solved') { emit(doc.id); } }")
	public List<ErrorTrace> findAllSolvedErrors() {
		return db.queryView(createQuery("all_solved__errors").includeDocs(true),
				ErrorTrace.class);
	}

}