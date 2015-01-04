/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAC2014Equipe3;

import static java.lang.System.out;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author juanmanuelmartinezromero
 */
@ManagedBean(name = "listNews")
@RequestScoped
public class ListNews {
    List<NewsEntity>news;
    
    @EJB
    private com.DAC2014Equipe3.NewsEntityFacadeLocal newsEntityFacade;

    @PostConstruct
    public void init() {
        news = newsEntityFacade.findAll();
    }
    
    /**
     * Creates a new instance of ListNews
     */
    public ListNews() {
    }

    public List<NewsEntity> getNews() {
        return news;
    }

    public void setNews(List<NewsEntity> news) {
        this.news = news;
    }

    public void processRequest() {
        List news = newsEntityFacade.findAll();
//        for (Iterator it = news.iterator(); it.hasNext();) {
//            NewsEntity elem = (NewsEntity) it.next();
//            out.println(" <b>" + elem.getTitle() + " </b><br />");
//            out.println(elem.getBody() + "<br /> ");
//        }
//        out.println("<a href='PostMessage'>Add new message</a>");
    }
}
