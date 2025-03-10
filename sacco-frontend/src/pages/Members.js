import { useEffect, useState } from 'react';
import { getMembers, deleteMember } from '../services/api';

function Members() {
    const [members, setMembers] = useState([]);

    useEffect(() => {
        fetchMembers();
    }, []);

    const fetchMembers = async () => {
        const data = await getMembers();
        setMembers(data);
    };

    const handleDelete = async (id) => {
        await deleteMember(id);
        fetchMembers(); // Refresh the list
    };

    return (
        <div>
            <h2>Members List</h2>
            <ul>
                {members.map((member) => (
                    <li key={member.member_id}>
                        {member.full_name} - {member.phone_number}
                        <button onClick={() => handleDelete(member.member_id)}>Delete</button>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default Members;
