import React, { useEffect, useState } from 'react';
import axios from 'axios';

export default function CategoryList(){
  const [categories, setCategories] = useState([]);
  useEffect(()=>{
    async function load(){
      try{
        const base = process.env.REACT_APP_API_URL || 'http://localhost:8080';
        const res = await axios.get(base + '/api/categories');
        setCategories(res.data || []);
      }catch(e){ console.error(e); }
    }
    load();
  },[]);

  return (
    <div>
      <ul>
        {categories.map(c => (
          <li key={c.id}>
            <strong>{c.name}</strong> — {c.description}
          </li>
        ))}
      </ul>
    </div>
  )
}
