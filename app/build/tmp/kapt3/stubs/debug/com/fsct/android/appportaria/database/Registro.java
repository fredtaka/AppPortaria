package com.fsct.android.appportaria.database;

import java.lang.System;

/**
 * Representa uma dia de acesso: cpf, entrada, saída, portaria
 *
 * // Avaliar se CPF usará Int ou Char (pode começar com zero)
 */
@androidx.room.Entity(tableName = "tabela_entrada_saida")
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\tH\u00c6\u0003J;\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010#\u001a\u00020\tH\u00d6\u0001J\t\u0010$\u001a\u00020%H\u00d6\u0001R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0014\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0017\u00a8\u0006&"}, d2 = {"Lcom/fsct/android/appportaria/database/Registro;", "", "registroId", "", "cpfPessoa", "", "horaEntradaMs", "horaSaidaMs", "grupoPessoa", "", "(JCJJI)V", "getCpfPessoa", "()C", "setCpfPessoa", "(C)V", "getGrupoPessoa", "()I", "setGrupoPessoa", "(I)V", "getHoraEntradaMs", "()J", "getHoraSaidaMs", "setHoraSaidaMs", "(J)V", "getRegistroId", "setRegistroId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
public final class Registro {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private long registroId;
    @androidx.room.ColumnInfo(name = "cpf_pessoa")
    private char cpfPessoa;
    @androidx.room.ColumnInfo(name = "hora_entrada_ms")
    private final long horaEntradaMs = 0L;
    @androidx.room.ColumnInfo(name = "hora_saida_ms")
    private long horaSaidaMs;
    @androidx.room.ColumnInfo(name = "grupo_pessoa")
    private int grupoPessoa;
    
    /**
     * Representa uma dia de acesso: cpf, entrada, saída, portaria
     *
     * // Avaliar se CPF usará Int ou Char (pode começar com zero)
     */
    @org.jetbrains.annotations.NotNull()
    public final com.fsct.android.appportaria.database.Registro copy(long registroId, char cpfPessoa, long horaEntradaMs, long horaSaidaMs, int grupoPessoa) {
        return null;
    }
    
    /**
     * Representa uma dia de acesso: cpf, entrada, saída, portaria
     *
     * // Avaliar se CPF usará Int ou Char (pode começar com zero)
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Representa uma dia de acesso: cpf, entrada, saída, portaria
     *
     * // Avaliar se CPF usará Int ou Char (pode começar com zero)
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Representa uma dia de acesso: cpf, entrada, saída, portaria
     *
     * // Avaliar se CPF usará Int ou Char (pode começar com zero)
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public Registro() {
        super();
    }
    
    public Registro(long registroId, char cpfPessoa, long horaEntradaMs, long horaSaidaMs, int grupoPessoa) {
        super();
    }
    
    public final long component1() {
        return 0L;
    }
    
    public final long getRegistroId() {
        return 0L;
    }
    
    public final void setRegistroId(long p0) {
    }
    
    public final char component2() {
        return '\u0000';
    }
    
    public final char getCpfPessoa() {
        return '\u0000';
    }
    
    public final void setCpfPessoa(char p0) {
    }
    
    public final long component3() {
        return 0L;
    }
    
    public final long getHoraEntradaMs() {
        return 0L;
    }
    
    public final long component4() {
        return 0L;
    }
    
    public final long getHoraSaidaMs() {
        return 0L;
    }
    
    public final void setHoraSaidaMs(long p0) {
    }
    
    public final int component5() {
        return 0;
    }
    
    public final int getGrupoPessoa() {
        return 0;
    }
    
    public final void setGrupoPessoa(int p0) {
    }
}