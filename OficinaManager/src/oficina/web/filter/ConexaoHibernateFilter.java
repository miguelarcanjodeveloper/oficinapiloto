package oficina.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.SessionFactory;

import oficina.util.Hibernateutil;

public class ConexaoHibernateFilter implements Filter{
	
	private SessionFactory sf;

	public void init(FilterConfig config) throws ServletException {
		this.sf=Hibernateutil.getSessionFactory();		
	}


	public void doFilter(ServletRequest serveletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		try {

			this.sf.getCurrentSession().beginTransaction();
			chain.doFilter(serveletRequest, servletResponse);
			this.sf.getCurrentSession().getTransaction().commit();
			this.sf.getCurrentSession().close();
		} catch (Throwable ex) {
			try {
				if(this.sf.getCurrentSession().getTransaction().isActive())
					this.sf.getCurrentSession().getTransaction().rollback();			
			
			}catch(Throwable t){
			t.printStackTrace();
			}
			throw new ServletException(ex);
		}	
	}

	
	public void destroy() {		
		
	}

}
