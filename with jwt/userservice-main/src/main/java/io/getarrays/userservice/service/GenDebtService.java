package io.getarrays.userservice.service;

import java.util.List;

import io.getarrays.userservice.domain.*;

public interface GenDebtService {

	public List<PayCashDesk> getAllCaisses();
	public List<PayImpPyMorg> getModesReglements(Long id);
	public List<GenAccount> getAllClientAccounts(Long id);
	public GenDebt EncaissementFacture(GenDebt genDebt);
	public List<GenDebt> getAllFactures();
	public GenDebt SearchFacture(String ref);
	public List<GenDebt> getClientsFactures(Long id);
	GenDebt getDebtById(Long id);
	List<Party> getAllParties();
	public Party getClientFact(GenDebt genDebt);
	public List<GenOrg> getAllOrgs();

}
