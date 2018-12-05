/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cis.pkg18c_final_;

/**
 *
 * @author Jesus Ramos
 */

// data structure to store graph edges
public class Edge
{
    private BaseRoom posA, posB;

    Edge(BaseRoom posA, BaseRoom posB)
    {
        this.posA = posA;
        this.posB = posB;
    }
    
    public BaseRoom getPosA()
    { return posA; }
    public BaseRoom getPosB()
    { return posB; }
}
