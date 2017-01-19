package com.example.linkedlist;

interface Collection<A> {
    public void add(A x);

    public Iterator<A> iterator();
}