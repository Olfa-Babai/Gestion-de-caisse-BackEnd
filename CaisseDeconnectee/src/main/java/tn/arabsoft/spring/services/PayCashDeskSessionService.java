package tn.arabsoft.spring.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.arabsoft.spring.models.PayCashDeskSession;
import tn.arabsoft.spring.repositories.*;

@Service
public class PayCashDeskSessionService implements IPayCashDeskSessionService {

	@Autowired
	IPayCashDeskSessionRepository payCashDeskSessionRepository;
	
	@Autowired
	IGenAgentRepository genAgentRepository; 
	
	@Autowired
	IPayCashDeskRepository payCashDeskRepository;
	
	@Autowired
	IAdmUserProfileRepository admUserProfileRepository;
	
	@Override
	public PayCashDeskSession add(PayCashDeskSession pcds, int idagent, int idd, int idaff) {
		pcds.setCss_startdt(LocalDateTime.now());
	//	pcds.setGenAgent(genAgentRepository.findById(idagent).orElse(null));
		pcds.setPaycashdesk(this.payCashDeskRepository.findById(idd).orElse(null));
		pcds.setUserprofile(this.admUserProfileRepository.findById(idaff).orElse(null));
		return payCashDeskSessionRepository.save(pcds);
	}

	@Override
	public PayCashDeskSession end_session(int id) {
		PayCashDeskSession s=this.payCashDeskSessionRepository.findById(id).orElse(null);
		s.setCss_enddt(LocalDateTime.now());
		return payCashDeskSessionRepository.save(s);
	}

	@Override
	public List<PayCashDeskSession> todaysSessions() {
		List<PayCashDeskSession> ps=(List<PayCashDeskSession>) this.payCashDeskSessionRepository.findAll();
		List<PayCashDeskSession> pst=new ArrayList<PayCashDeskSession>();
		// todays date : 
		LocalDateTime localDateTime = LocalDateTime.now();
		for(PayCashDeskSession p : ps){
			if(p.getCss_startdt().getDayOfMonth() == LocalDateTime.now().getDayOfMonth() && p.getCss_startdt().getMonth()==localDateTime.getMonth() && p.getCss_startdt().getYear()==localDateTime.getYear()){
				pst.add(p);
			}
		}
		return pst;
	}
	
	@Override
	public List<PayCashDeskSession> allSessions() {
		return (List<PayCashDeskSession>) this.payCashDeskSessionRepository.findAll();
	}
	
	@Override
	public List<PayCashDeskSession> todayencours() {
		List<PayCashDeskSession> all=(List<PayCashDeskSession>) payCashDeskSessionRepository.findAll();
		List<PayCashDeskSession> ps=new ArrayList<PayCashDeskSession>();
		for(PayCashDeskSession p : all){
			if(p.getCss_enddt()==null){
				ps.add(p);
			}
		}
		return ps;
	}

	@Override
	public List<PayCashDeskSession> todayended() {
		List<PayCashDeskSession> all=(List<PayCashDeskSession>) payCashDeskSessionRepository.findAll();
		List<PayCashDeskSession> ps=new ArrayList<PayCashDeskSession>();
		for(PayCashDeskSession p : all){
			if(!p.getCss_enddt().equals(null)){
				ps.add(p);
			}
		}
		return ps;
	}

}
