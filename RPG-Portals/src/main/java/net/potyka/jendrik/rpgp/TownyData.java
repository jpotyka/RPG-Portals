package net.potyka.jendrik.rpgp;

import org.bukkit.entity.Player;

import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.exceptions.NotRegisteredException;
import com.palmergames.bukkit.towny.object.Town;

import net.potyka.jendrik.rpgp.App;

public class TownyData
{
    private TownyAPI townyapi;
    private App app;

    public TownyData(App app)
    {
        this.townyapi = TownyAPI.getInstance();
        this.app = app;
    }



    public boolean playerIsTownMember(Player player) 
    {
        try {
            townyapi.getDataSource().getResident(player.getName()).getTown();
        } 
        catch (NotRegisteredException ex)         
        {
            app.getServer().getLogger().info("Something went wrong in the Towny API, this should never happen!" + ex.toString());
            return false;
        } 
        return true;
    }

    public Town playersTown(Player player)
    {
        Town town;
        try {
            town = townyapi.getDataSource().getResident(player.getName()).getTown();
        } 
        catch (NotRegisteredException ex)         
        {
            app.getServer().getLogger().info("Something went wrong in the Towny API, this should never happen!" + ex.toString());
            return null;
        } 
        return town;
    }

}