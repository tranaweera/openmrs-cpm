package org.openmrs.module.cpm.api.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.APIException;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.cpm.ProposedConcept;
import org.openmrs.module.cpm.ProposedConceptPackage;
import org.openmrs.module.cpm.ProposedConceptResponsePackage;
import org.openmrs.module.cpm.api.ProposedConceptService;
import org.openmrs.module.cpm.api.db.ProposedConceptDAO;
import org.openmrs.module.cpm.api.db.ProposedConceptPackageDAO;
import org.openmrs.module.cpm.api.db.ProposedConceptPackageResponseDAO;
import org.springframework.stereotype.Service;

@Service("org.openmrs.module.cpm.api.ProposedConceptService")
public class ProposedConceptServiceImpl extends BaseOpenmrsService implements ProposedConceptService {
	
	private static final Log log = LogFactory.getLog(ProposedConceptServiceImpl.class);
	
	@Resource(name = "hibernateProposedConceptPackageDAO")
	private ProposedConceptPackageDAO proposalDao;
	@Resource(name = "hibernateProposedConceptPackageResponseDAO")
	private ProposedConceptPackageResponseDAO proposalResponseDao;
  @Resource(name = "hibernateProposedConceptDAO")
  private ProposedConceptDAO proposedConceptDao;

	//	Starting with all of the services for the client side of the ProposedConcept module
	
	@Override
    public List<ProposedConceptPackage> getAllProposedConceptPackages() throws APIException {
	    return proposalDao.getAllConceptProposalPackages();
    }

	@Override
    public ProposedConceptPackage getProposedConceptPackageById(Integer id) throws APIException {
		return proposalDao.getConceptProposalPackageById(id);
    }

	@Override
    public ProposedConceptPackage getProposedConceptPackageByUuid(String uuid) throws APIException {
		return proposalDao.getConceptProposalPackageByUuid(uuid);
    }

	@Override
    public ProposedConceptPackage saveProposedConceptPackage(ProposedConceptPackage conceptPackage) throws APIException {
		return proposalDao.saveConceptProposalPackage(conceptPackage);
    }

	@Override
    public void deleteProposedConceptPackage(ProposedConceptPackage conceptPackage) throws APIException {
		proposalDao.deleteConceptProposalPackage(conceptPackage);
    }
	
	//	Moving on to all of the services for the server side of the Concept Proposal Module
	
	@Override
	public List<ProposedConceptResponsePackage> getAllProposedConceptResponsePackages() throws APIException {
		return proposalResponseDao.getAllConceptProposalResponsePackages();
	}
	
	@Override
	public ProposedConceptResponsePackage getProposedConceptResponsePackageById(Integer id) throws APIException {
		return proposalResponseDao.getConceptProposalResponsePackageById(id);
	}
	
	@Override
	public ProposedConceptResponsePackage getProposedConceptResponsePackageByProposalUuid(String uuid) throws APIException {
		return proposalResponseDao.getConceptProposalResponsePackageByProposalUuid(uuid);
	}
	
	@Override
	public ProposedConceptResponsePackage saveProposedConceptResponsePackage(ProposedConceptResponsePackage conceptPackageResponse) throws APIException {
		return proposalResponseDao.saveConceptProposalResponsePackage(conceptPackageResponse);
	}
	
	@Override
	public void deleteProposedConceptResponsePackage(ProposedConceptResponsePackage conceptPackageResponse) throws APIException {
		proposalResponseDao.deleteConceptProposalResponsePackage(conceptPackageResponse);
	}

  @Override
  public void deleteProposedConcept(ProposedConcept proposedConcept) throws APIException {
      proposedConceptDao.deleteProposedConcept(proposedConcept);
  }
	
}
