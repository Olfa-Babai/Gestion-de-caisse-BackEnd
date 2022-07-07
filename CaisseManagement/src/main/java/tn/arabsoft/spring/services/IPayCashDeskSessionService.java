package tn.arabsoft.spring.services;

import java.util.List;

import tn.arabsoft.spring.models.PayCashDeskSession;

public interface IPayCashDeskSessionService {
	
	// Ajout d'une session
	public PayCashDeskSession add(PayCashDeskSession pcds, int idagent, int idd, int idaff);
	// Arrêt de la session appelée
	public PayCashDeskSession end_session(int id);
	// Les sessions ouvertes aujourd'hui
	public List<PayCashDeskSession> todaysSessions();
	// Toutes les sessions
	public List<PayCashDeskSession> allSessions();
	// Les sessions en cours
	public List<PayCashDeskSession> todayencours();
	// Les sessions terminées
	public List<PayCashDeskSession> todayended();
}
