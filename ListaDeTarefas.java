package com.mycompany.listadetarefas;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaDeTarefas {
    
    private static ArrayList<Tarefa> lista = new ArrayList<Tarefa>();
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
            
        boolean rodando = true;
        
        while(rodando){
            System.out.println("[1] Mostrar tarefas");
            System.out.println("[2] Mostrar tarefas finalizadas");
            System.out.println("[3] Mostrar tarefas nao finalizadas");
            System.out.println("[4] Adicionar tarefa");
            System.out.println("[5] Finalizar tarefa");
            System.out.println("[6] Remover tarefa");
            System.out.println("[7] Sair");
            System.out.print("Digite a opcao: ");
            
            String opcao = scanner.nextLine();
            
            switch (opcao) {
                case "1": {
                    System.out.println("\n=== TAREFAS ===");
                     
                    if(lista.isEmpty()){
                        System.out.println("Lista de tarefas vazia.");
                    }
                    
                    for(int i=0; i < lista.size(); i++){
                        
                        Tarefa t = lista.get(i);
                        System.out.println("Tarefa " +(i+1));
                        System.out.println("\tTitulo: " +t.getTitulo());
                        System.out.println("\tFinalizada: " + t.isFinalizada());
                    }
                    break;
                }
                case "2": {
                    System.out.println("\n=== TAREFAS FINALIZADAS ===");
                    
                    ArrayList<Tarefa> finalizadas = new ArrayList<>();
                    
                    for(Tarefa t: lista){
                        if(t.isFinalizada()){
                            finalizadas.add(t);
                        }
                    }
                    if(finalizadas.isEmpty()){
                        System.out.println("Nenhuma tarefa finalizada");
                    }
                    for(int i=0; i < finalizadas.size(); i++){
                        Tarefa t = finalizadas.get(i);
                        System.out.println("Tarefa " + i);
                        System.out.println("\tTitulo: " +t.getTitulo());
                        System.out.println("\tFinalizada: " + t.isFinalizada());
                    }
                    break;
                }
                case "3": {
                    System.out.println("\n=== TAREFAS NAO FINALIZADAS ===");
                    
                    ArrayList<Tarefa> naoFinalizada = new ArrayList<>();
                    
                    for (Tarefa t : lista){
                        if(!t.isFinalizada()){
                            naoFinalizada.add(t);
                        }
                    }
                    if(naoFinalizada.isEmpty()){
                        System.out.println("Nao ha tarefas em aberto");
                    }
                    for (int i = 0; i < naoFinalizada.size(); i++){
                        Tarefa t = naoFinalizada.get(i);
                        System.out.println("Tarefa " + i);
                        System.out.println("\tTitulo: " +t.getTitulo());
                        System.out.println("\tFinalizada: " + t.isFinalizada());
                    }
                    
                    break;
                }
                case "4": {
                    System.out.println("\n=== NOVA TAREFA ===");
                    
                    System.out.println("Digite o titulo: ");
                    String titulo = scanner.nextLine();
                    
                    lista.add(new Tarefa(titulo));
                    System.out.println("Tarefa adicionada");
                    break;
                }
                case "5": {
                    System.out.println("\n=== FINALIZAR TAREFA ===");
                    ArrayList<Tarefa> naoFinalizada = new ArrayList<>();
                    
                    for( Tarefa t : lista){
                        if(!t.isFinalizada()){
                        naoFinalizada.add(t);
                        }
                    }
                    if (naoFinalizada.isEmpty()) {
                        System.out.println("Lista de tarefas vazia.");
                    }
                    System.out.println("Escolha a tarefa para finalizar:");
                    
                    for (int i = 0; i < naoFinalizada.size(); i++) {
                        System.out.println("[" + i + "] " + lista.get(i).getTitulo());  
                    }
                   
                    System.out.print("Digite o numero da tarefa para finalizar: ");
                    int index = Integer.parseInt(scanner.nextLine());
                    
                    if (index >= 0 && index < naoFinalizada.size()) {
                        Tarefa tarefaFinalizada = naoFinalizada.get(index);
                        tarefaFinalizada.setFinalizada(true);
                        System.out.println("Tarefa finalizada.");
                    }
                    else{
                        System.out.println("Numero invalido.");
                    }
                    break;
                }
                case "6": {
                   System.out.println("\n=== REMOVER TAREFA ===");
                   if (lista.isEmpty()){
                    System.out.println("Lista de tarefas vazia.");
                   }
                   
                   else {
                    System.out.println("Tarefas:");
                    
                    for (int i = 0; i < lista.size(); i++) {
                        System.out.println("[" + i + "] " + lista.get(i).getTitulo());
                    }
                    System.out.print("Digite o numero da tarefa que deseja remover: ");
                    int index = Integer.parseInt(scanner.nextLine());
                    if (index >= 0 && index < lista.size()) {
                        lista.remove(index);
                        System.out.println("Tarefa removida.");
                    }
                    else{
                        System.out.println("Numero inválido.");
                        }
                    }
                    break;
                }
                case "7": {
                    rodando = false;
                    System.out.println("Encerrando o programa");
                    break;
                }
                default:  {
                    System.out.println("Opcao Invalida");
                    break;
                }
            }
        }
        System.out.println("Fim do programa.");
    }
}
