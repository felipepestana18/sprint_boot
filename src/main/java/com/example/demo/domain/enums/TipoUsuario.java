/*
 * package com.example.demo.domain.enums;
 * 
 * public enum TipoUsuario {
 * 
 * 
 * PESSOAFISICA(1), PESSOAJURIDICA(2);
 * 
 * private int cod;
 * 
 * 
 * private TipoUsuario(int cod) { this.cod = cod;
 * 
 * }
 * 
 * public int getCod() { return cod; }
 * 
 * 
 * public static TipoUsuario toEnum(Integer cod) {
 * 
 * if (cod == null) { return null; }
 * 
 * for (TipoUsuario x : TipoUsuario.values()) { if (cod.equals(x.getCod())) {
 * return x; } }
 * 
 * throw new IllegalArgumentException("Id inválido: " + cod); } }
 */