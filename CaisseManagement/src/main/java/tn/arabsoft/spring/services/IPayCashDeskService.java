package tn.arabsoft.spring.services;

import java.util.List;

import tn.arabsoft.spring.models.PayCashDesk;

public interface IPayCashDeskService {

	//c
	public PayCashDesk addCaisse(PayCashDesk c, int[] id);
	//r
	public PayCashDesk getCaisse(int id);
	//ra
	public List<PayCashDesk> getAllCaisse();
	//u
	public PayCashDesk updateCaisse(PayCashDesk c);
	//d
	public void deleteCaisse(int id);
}
