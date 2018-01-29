package br.com.squadra.segurancadigital.repository.sistema;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.squadra.segurancadigital.model.Sistema;
import br.com.squadra.segurancadigital.repository.filter.SistemaFilter;

public class SistemaRepositoryImpl implements SistemaRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Sistema> filtrar(SistemaFilter filter) {
		Session session = manager.unwrap(Session.class);

		Criteria criteria = session.createCriteria(Sistema.class);

		if (StringUtils.isNotEmpty(filter.getDescricao())) {
			criteria.add(Restrictions.like("descricao", filter.getDescricao(), MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotEmpty(filter.getSigla())) {
			criteria.add(Restrictions.eq("sigla", filter.getSigla()));
		}
		if (StringUtils.isNotEmpty(filter.getEmail())) {
			criteria.add(Restrictions.eq("email", filter.getEmail()));
		}

		return criteria.list();
	}
}
