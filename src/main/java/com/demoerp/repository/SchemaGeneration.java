package com.demoerp.repository;

import com.demoerp.entity.Empresa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SchemaGeneration {

    public static void main(String[] args) {
        // Logger
        Logger logger = Logger.getLogger(SchemaGeneration.class.getName());
        logger.setLevel(Level.INFO);

        // EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demoerpPU");
        EntityManager em = emf.createEntityManager();

        try {
            List<Empresa> lista = em.createQuery("from Empresa", Empresa.class).getResultList();

            // Log com a lista
            logger.info(() -> String.format("Lista de empresas: %s", lista));
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao executar a consulta: {0}", e.getMessage());
        } finally {
            // Fechar EntityManager
            em.close();
            emf.close();
        }
    }
}
