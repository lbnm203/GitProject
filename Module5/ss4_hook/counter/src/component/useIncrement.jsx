import React, { useState } from 'react';

export const useIncrement = (num) => {
    const [count, setCount] = useState(0);

    const increment = () => {
        setCount(prev => prev + num)
    };

    return [count, increment];
}