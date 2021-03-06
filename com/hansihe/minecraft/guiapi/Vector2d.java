/*
 * $RCSfile$
 *
 * Copyright 1998-2008 Sun Microsystems, Inc.  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Sun designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Sun in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Sun Microsystems, Inc., 4150 Network Circle, Santa Clara,
 * CA 95054 USA or visit www.sun.com if you need additional information or
 * have any questions.
 *
 * $Revision$
 * $Date$
 * $State$
 */

package com.hansihe.minecraft.guiapi;

import java.lang.Math;

/**
 * A 2-element vector that is represented by double-precision floating 
 * point x,y coordinates.
 *
 */
public class Vector2d implements java.io.Serializable {

    // Combatible with 1.1
    static final long serialVersionUID = 8572646365302599857L;

    public double x;
    public double y;
    
    /**
     * Constructs and initializes a Vector2d from the specified xy coordinates.
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Vector2d(double x, double y)
    {
      this.x = x;
      this.y = y;
    }

    /**
     * Constructs and initializes a Vector2d to (0,0).
     */
    public Vector2d()
    {
        this.x = 0;
        this.y = 0;
    }

    
    public final Vector2d subtract(Vector2d v1)
    {
    	return new Vector2d(this.x-v1.x, this.y-v1.y);
    }
    

  /**
   * Computes the dot product of the this vector and vector v1.
   * @param v1 the other vector
   */
    public final double dot(Vector2d v1)
    {
      return (this.x*v1.x + this.y*v1.y);
    }


    /**  
     * Returns the length of this vector.
     * @return the length of this vector
     */  
    public final double length()
    {
        return (double) Math.sqrt(this.x*this.x + this.y*this.y);
    }

    /**  
     * Returns the squared length of this vector.
     * @return the squared length of this vector
     */  
    public final double lengthSquared()
    {
        return (this.x*this.x + this.y*this.y);
    }

    /**
     * Sets the value of this vector to the normalization of vector v1.
     * @param v1 the un-normalized vector
     */  
    public final void normalize(Vector2d v1)
    {
        double norm;

        norm = (double) (1.0/Math.sqrt(v1.x*v1.x + v1.y*v1.y));
        this.x = v1.x*norm;
        this.y = v1.y*norm;
    }

    /**
     * Normalizes this vector in place.
     */  
    public final void normalize()
    {
        double norm;

        norm = (double)
               (1.0/Math.sqrt(this.x*this.x + this.y*this.y));
        this.x *= norm;
        this.y *= norm;
    }


  /**
    *   Returns the angle in radians between this vector and the vector
    *   parameter; the return value is constrained to the range [0,PI].
    *   @param v1    the other vector
    *   @return   the angle in radians in the range [0,PI]
    */
   public final double angle(Vector2d v1)
   {
      double vDot = this.dot(v1) / v1.length();//( this.length()*v1.length() );
      if( vDot < -1.0) vDot = -1.0;
      if( vDot >  1.0) vDot =  1.0;
      return((double) (Math.acos( vDot )));

   }


}
